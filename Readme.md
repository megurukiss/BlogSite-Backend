The frontend of the project is in [https://github.com/megurukiss/BlogSite](https://github.com/megurukiss/BlogSite)

## APIs

### Portal API for all users
- **`/api/portal/getRecentBlogs`**: Get request, get recent 3 blogs, retrun a list of blog objects
#### response data
```json
[
    {
        "bid": 1,
        "title": "title",
        "content": "content",
        "createdTime": "2021-01-01 00:00:00",
        "updatedTime": "2021-01-01 00:00:00",
        "uid": 1
    },
    ...
]
```

- **`/api/portal/getBlogById?id=1 `**: Get request, get blog detail by blog id, take blog id as parameter, return a blog object
#### response data
```json
{
    "bid": 1,
    "title": "title",
    "content": "content",
    "createdTime": "2021-01-01 00:00:00",
    "updatedTime": "2021-01-01 00:00:00",
    "uid": 1
}
```

- **`/api/portal/getBlogByPage?page=1&limit=10`**: Get request, get blogs by page, take page number and limit as parameter, return a list of blog objects,`(TODO)`
#### response data
```json
[
    {
        "bid": 1,
        "title": "title",
        "content": "content",
        "createdTime": "2021-01-01 00:00:00",
        "updatedTime": "2021-01-01 00:00:00",
        "uid": 1
    },
    ...
]
```

- **`/api/portal/getAllBlogs`**: Get request, get all blogs, return a list of blog objects
#### response data
```json
[
    {
        "bid": 1,
        "title": "title",
        "content": "content",
        "createdTime": "2021-01-01 00:00:00",
        "updatedTime": "2021-01-01 00:00:00",
        "uid": 1
    },
    ...
]
```


### User API for admin
- **`/api/user/login`**: Post request, login, take email and password in request body, return a token
#### request body
```json
{
            "email":"zhangsan@ssss.com",
            "userPwd":"123456"
        }
```

- **`/api/user/register`**: Post request, register, take email, password and nickname in request body, return a token`(TODO)`

- **`/api/user/getUserInfo`**: Get request, get user info, take token in request header, return a user object
#### response data
```json
{
    "uid": 1,
    "email": "chf007@ucsd.edu",
    "username": "meguru_kiss",
    "password": "123456",
    }
```

- **`/api/user/checkLogin`**: Get request, check if user is logged in, take token in request header, return a status code.
```json
{
    "code": 200,
    "message": "success"
    "data":null,    
}
```

### Blog API for admin to manage blogs

- **`/api/blog/addBlog`**: Post request, add blog, take title and content in request body, return a status code
#### request body
```json
{
    "title": "title",
    "content": "content"
}
```

- **`/api/blog/updateBlog`**: Post request, update blog, take blog id, title and content in request body, return a status code
#### request body
```json
{
    "bid": 1,
    "title": "title",
    "content": "content"
}
```

- **`/api/blog/deleteBlog`**: Post request, delete blog, take blog id in request body, return a status code
#### request body
```json
{
    "bid": 1
}
```




## Backend Structure

### Utils

- **`JDBCUtil`**: create connection to database
- **`JwtUtil`**: create and verify JWT token
- **`MD5Util`**: encrypt password
- **`WebUtil`**: convert from json to object and vice versa

### common
- **`Result`**: response object
- **`ResultCodeEnum`**: response code with message

### dao layer
-**`BaseDao`**: base class for all dao classes
- **`UserDao`**: user dao, contains all user database related operations
- **`BlogDao`**: blog dao, contains all blog database related operations

### pojo layer
- **`User`**: user object
- **`Blog`**: blog object

### controller layer
- **`UserController`**: user controller, contains all user related APIs
- **`BlogController`**: blog controller, contains all blog related APIs
- **`PortalController`**: portal controller, contains all portal related APIs
- **`BaseController`**: base class for all controllers

### service layer
- **`UserService`**: user service, contains all user related operations
- **`BlogService`**: blog service, contains all blog related operations


### filter 
- **`LoginFilter`**: filter to check if user is logged in
- **`CorsFilter`**: filter to enable CORS



