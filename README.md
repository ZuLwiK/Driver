# Driver
REST API with driving advices and training exercises

The purpose of this project is to create a website where everybody can become acquainted with many counsels concern safe on the road. 

[IN PROGRESS]
This website will have many articles invole safe on the road and quizzes, where everybody can check own knowledge.

## Steps to Setup

**1. Clone the repository** 

```bash
git clone https://github.com/ZuLwiK/Driver.git
```

**2. Specify the file uploads directory**

Open `src/main/resources/application.properties` file and change the property `file.upload-dir` to the path where you want the uploaded files to be stored.

```
file.upload-dir=/uploads
```

**2. Run the app using maven**

```bash
cd Driver
mvn spring-boot:run
```

That's it! The application can be accessed at `http://localhost:8080`.
