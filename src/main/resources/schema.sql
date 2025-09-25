DROP TABLE IF EXISTS dbo.course;
CREATE TABLE dbo.course (
    courseid INT NOT NULL PRIMARY KEY,
    course_name VARCHAR(1000) NOT NULL,
    rating DECIMAL(3,1) NOT NULL
);
