### launch.json
```json
{
    "configurations": [
        {
            "type": "java",
            "name": "Spring Boot-XpnsApplication<xpns>",
            "request": "launch",
            "cwd": "${workspaceFolder}",
            "mainClass": "com.krvish.xpns.XpnsApplication",
            "projectName": "xpns",
            "args": "",
            "env": {
                "JWT_SECRET": "9f1e3c7b8a6d4e5f1a2b3c4d5e6f7a8b9c0d1e2f3a4b5c6d7e8f9a0b1c2",
                "JWT_EXPIRATION_MS": "3600000",
                "DB_URL": "jdbc:postgresql://localhost:5432/xpnsdb",
                "DB_USERNAME": "postgres",
                "DB_PASSWORD": "root"
            }
        }
    ]
}


```