node{
    stage('checkout repo'){
    git branch: 'master',
    credentialsId: 'efabc226-55f4-40d1-8a5f-2b48e0b2c48c',
    url: 'https://github.com/ashipovalov/automation_training'
}

stage ('build'){
    sh "./gradlew clean api-tests:assemble"
}

stage ('Run tests'){
    sh "./gradlew clean api-tests:test"
}
}