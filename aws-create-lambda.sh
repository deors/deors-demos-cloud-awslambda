aws lambda create-function \
--function-name HelloLambda \
--role arn:aws:iam::$AWS_ACCOUNT_ID:role/lambdaTestRole \
--zip-file fileb:///Users/jorgehidalgo/code/projects/deors.demos/deors-demos-cloud-awslambda/target/deors-demos-cloud-awslambda-1.0-SNAPSHOT.jar \
--handler deors.demos.cloud.awslambda.HelloLambda \
--description "HelloLambda" \
--runtime java8 \
--timeout 30 \
--memory-size 1024 \
--publish
