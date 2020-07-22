# deors-demos-cloud-awslambda

Demonstration of a simple Java project deployed as a function in Amazon Web Services Lambda.

## Security configuration

Before creating, updating or running a Lambda function, it is needed to set up the security configuration in terms of user and role.

The user is the entity with permissions to create, update and run (for testing purposes) the function from the command line.

The role is the entity for the Lambda function itself, with the necessary permissions that the Lambda will need to perform its logic, typically permissions to use other AWS services.

To begin, an existing user with access to the management console and IAM admin role is required to perform the configuration. Log in to the management console with that user and switch to IAM service.

Click on 'Users' in the left menu, and then click the 'Add user' button in the horizontal menu. Name the user `lambdaTest` for example, and enable the 'Programmatic access' checkbox. Management console access is not needed for this use. For its permissions, let's add the `AWSLambdaFullAccess` policy. Finish the creation of the user and take note of the access key id and the secret access key (they will not be shown again once the window is closed).

Next, let's create the Lambda execution role. Click on 'Roles' in the left menu, and then click the 'Create role' button in the horizontal menu. Choose 'Lambda' for the service that will use the role and click on 'Next: Permissions' button in the bottom menu. This function is so simple than just the `AWSLambdaBasicExecutionRole` will suffice. More complex functions will require extra permissions, e.g. to read or put objects to S3, query a DynamoDB table, or invoke other Lambdas. Continue to the next steps and finish the role by setting its name to `lambdaTestRole`. The role name can be any, but `lambdaTestRole` is the name used by the convenience scripts in this repository.

Once the user and role are ready, on a terminal with AWS CLI installed, run the `aws configure` command. Use the access key id and the secret access key for the just created user to configure the AWS CLI credentials, and set the AWS region in which the Lambda will be created and executed.

The Lambda creation script assumes that the `AWS_ACCOUNT_ID` environment variable exists, and is used to set the Lambda execution role, so let's set its value to the specific AWS account id:

```
export AWS_ACCOUNT_ID=<the-aws-account-id>
```

## Lambda lifecycle

Use Apache Maven to compile and package the Lambda function:

```
mvn clean package
```

Once this is ready, use the scripts to perform basic Lambda lifecycle operations:

* `aws-create-lambda`: To create the Lambda function from the packaged fat Jar file.
* `aws-update-lambda`: To update the Lambda function.
* `aws-test-lambda`: To run the Lambda function with some test data.

