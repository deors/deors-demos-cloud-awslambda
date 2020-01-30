aws lambda invoke \
--function-name HelloLambda \
--region eu-west-1 \
--payload "{\"name\": \"deors macphail\", \"age\": 42}" \
output.json
