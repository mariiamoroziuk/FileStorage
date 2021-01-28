# FileStorage

you can see all the documentation and try endpoints on your <server_port> /doc (example http://localhost:8080/doc)

make sure you are connected to the Elasticsearch before starting, settings in resources.application.yml

ENPOINTS:

POST /file
    
    {
       "name": "file_name.ext"
       "size" : 121231                           
    }

    returns status 200 and body:
    {"id": "unique file id"}

    or status 400 with error if one of the field is absent or has incorrect value (like negative file size)
    {
      "success": false,
      "error": "error description"
    }
    
DELETE  /file/{ID}

    returns status 200 and body
    {"success": true}

    or 404 and body
    {
      "success": false,
      "error": "file not found"
    }
    
POST /file/{ID}/tags

    ["tag1", "tag2", "tag3"]

    returns status 200 and body
    {"success": true}

DELETE /file/{ID}/tags

    ["tag1", "tag3"]

    returns status 200 if all OK and body
    {"success": true}

    returns status 400 if one of the tags is not present on the file and body
    {
      "success": false,
      "error": "tag not found on file"
    }
    
GET /file?tags=tag1,tag2,tag3&page=2&size=3
    
    {
       "total": 25,
       "page": [
           {
              "id": "ID1",
              "name": "presentation.pdf",
              "size": 123123,
              "tags": ["work"]
           },
           {
              "id": "ID2",
              "name": "file.mp3",
              "size": 123123,
              "tags": ["audio", "jazz"]
           },
           {
              "id": "ID3",
              "name": "film.mp4",
              "size": 123123,
              "tags": ["video"]
           }
       ]
    }

