
# Task-2 Backend Using Spring Boot

A Spring Boot backend with APIs for user onboarding.





## Features

- Sign Up: User registration.
- Sign In: User authentication.
- Forgot Password: Mock password reset functionality


## Run Locally

Go to directory

```bash
  cd assignment
```
Open IntelliJIdea or any Java Code Editor and run 
AssignmentApplication.java file present in 
```bash
    src/main/java/AssignmentApplication.java
```
- After starting the application go to postman and run following 
- Note - Use POST request for all these commands

# For Registration 
```bash
localhost:8080/auth/register
```
In the body write this
```
{
    "username" : "test3",
    "password" : "test3"
}
```

# For Login 

```bash
localhost:8080/auth/login
```
In the body write this
```
{
    "username" : "test3",
    "password" : "test3"
}
```

# For Reset password
```bash
localhost:8080/auth/reset-password
```

In the body write this
```
{
    "username" : "test3",
    "newPassword" : "test1",
    "confirmPassword" : "test1"
}
```

## Support

For support, email goyalsumit651@gmail.com 

## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/sumit-goyal-87207a213/)
### My LeetCode Progress
https://leetcode.com/u/goyalsumit651/





## Authors

 [@Sumit](https://www.github.com/Sumit240803)

