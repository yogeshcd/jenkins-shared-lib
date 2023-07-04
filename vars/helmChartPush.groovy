def call(Map creds) {
        withCredentials([string(credentialsId: 'aws_account_id', variable: 'aws_account_id')]) {
        // some block
                    // /bin/bash HELM_CHART_VERSION=$(helm inspect chart . | grep version: | awk '{print $2}')
            //helm push helm-test-chart-0.1.0.tgz oci://aws_account_id.dkr.ecr.us-west-2.amazonaws.com/
            sh """
            echo $HELM_CHART_VERSION
            helm package ${creds.package_name}
            aws ecr get-login-password --region ${creds.region} | helm registry login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${creds.region}.amazonaws.com
            
            helm push ${creds.package_name}-$HELM_CHART_VERSION.tgz oci://${aws_account_id}.dkr.ecr.${creds.region}.amazonaws.com/
            """


    }
}