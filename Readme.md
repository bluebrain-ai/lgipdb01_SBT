## <componentName>

### _Description_

- <comments>

##Ownership 
| Ownership| |
|--------|------|
|Domain| <Domain> |
|Account|<Account>|
| Author| <bluescript>|


###Tech stack

<componentName> uses follwing tech stacks/frameworks:

| Libraries | Version |
| ------ | ------ |
| Spring Boot | [2.x][PlDb] |
| Spring core | [5.1][PlDb] |
| Spring cloud | [2.1][PlDb] |
| Kafka| [2.1][PlDb] |
| Open API | [3.0][PlDb] |
| Java | [14][PlDb] |



### compile and Install 

```sh 
cd <componentName> 
mvn install

### Development
mvn install  --Dprofile == "PRODUCTION"

### For production environments...
mvn install  --Dprofile == "PRODUCTION"

```

## Docker

Docker verison  V1.2
Docker build details and commands
```sh
cd <componentName>
docker build -t <youruser>/dillinger:${package.json.version} .

<componentName> Docker image runs on <host>:<port>

docker run -d -p <port>:<port> --restart=always --cap-add=SYS_ADMIN --name=<componentName> <youruser>/<componentName>:<dockerImageVersion>
```
##CI/CD
	 CI Job Details
	 CT Job Details
	 CD Job Details

## Verify/Run

Verify the deployment by navigating to your server address in
your preferred browser.

```sh
127.0.0.1:8000
```
Production Deployment
CD

## License



[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [bluescript]: <https://bluescript.ai>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
