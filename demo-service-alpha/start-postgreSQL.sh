dbVersion="11-alpine"
dbName=postgres
dbUser=postgres
dbPass=postgres

echo -e "\\nStarting docker container postgresDB...\\n"
docker run --rm --name postgres -e POSTGRES_PASSWORD=${dbPass} -e POSTGRES_USER=${dbUser} -e POSTGRES_DB=${dbName} -d -p 127.0.0.1:5432:5432 postgres:${dbVersion}
echo -e "\\nTo stop the database, execute: docker stop postgresDB\\n"
