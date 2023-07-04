def call(Map creds) {
        withCredentials([string(credentialsId: 'aws_account_id', variable: 'aws_account_id')]) {
        // some block
            sh """
            helm package ${creds.helm_chart_name}

            aws ecr get-login-password --region us-east-1 | helm registry login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.us-east-1.amazonaws.com

            
            HELM_CHART_VERSION=$(helm inspect chart . | grep version: | awk '{print $2}')
            
            helm push helm-test-chart-$HELM_CHART_VERSION.tgz oci://${aws_account_id}.dkr.ecr.${creds.region}.amazonaws.com/
            """
    }
}