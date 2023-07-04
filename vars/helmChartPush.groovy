def call(Map creds) {
        withCredentials([string(credentialsId: 'aws_account_id', variable: 'aws_account_id')]) {
        // some block
            sh """
            helm package ${creds.package_name}
            """
    }
}