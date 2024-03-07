
## Backend Structure

### Utils

- **`JDBCUtil`**: create connection to database
- **`JwtUtil`**: create and verify JWT token
- **`MD5Util`**: encrypt password
- **`WebUtil`**: convert from json to object and vice versa

### common
- **`Result`**: response object
- **`ResultCodeEnum`**: response code with message

### dao
-**`BaseDao`**: base class for all dao classes
- **`UserDao`**: user dao, contains all user related operations
- **`BlogDao`**: blog dao, contains all blog related operations

### pojo
- **`User`**: user object
- **`Blog`**: blog object
