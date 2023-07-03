def call(Map creds) {
        withCredentials([string(credentialsId: 'aws_account_id', variable: 'aws_account_id')]) {
        // some block
            sh """
            helm install ${creds.release_name} oci://${aws_account_id}.dkr.ecr.${creds.region}.amazonaws.com/${creds.helm_chart_name} --version $HELM_CHART_VERSION
            """
    }
}