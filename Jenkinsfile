node{
    stage("checkout repo"){
    git branch: 'main',
    credentialsId: 'efabc226-55f4-40d1-8a5f-2b48e0b2c48c',
    url: 'https://github.com/ashipovalov/automation_training'
}

stage ("build"){
    sh ("chmod +x gradlew")
    sh "./gradlew clean api-tests:assemble"
}

stage ("Run tests"){
    sh "./gradlew clean api-tests:test -Dlogging=${LOGGING}"

}

allure([
properties: [],
reportBuildPolicy: 'ALWAYS',
results: [[path: 'api-tests/build/allure-results']]

])

}