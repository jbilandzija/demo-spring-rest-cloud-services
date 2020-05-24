dbVersion="4.2.6"

echo -e "\\nStarting docker container mongodb...\\n"
docker run -d -p 127.0.0.1:27017:27017 --name mongodb mongo:${dbVersion}
echo -e "\\nTo stop the database, execute: docker stop mongodb\\n"
