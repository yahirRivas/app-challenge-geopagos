# app-challenge-geopagos

Torneo eliminación directa

### Pasos para ejecutar el app de manera localmente

_1) Instalar **Docker**_

_2) Instalar **Docker-compose**_

_Comandos_
	
* **docker-compose up** _da instrucciones a Docker para crear el contendor y ejecutarlo._

* **docker-compose down** _apaga todo los servicios que levantó con docker-compose up._

_3) Ejecutar_

```
~/app-challenge-geopagos$  docker-compose up
```



### Documentación en Swagger

[http://localhost:8080/app-challenge-geopagos/api-docs](http://localhost:8080/app-challenge-geopagos/api-docs)

[http://localhost:8080/app-challenge-geopagos/swagger-ui/index.html](http://localhost:8080/app-challenge-geopagos/swagger-ui/index.html)

### Llamadas http a los servicios mediante comandos

_**GET** Lista los participantes_ 
_Parámetro gender es opcional, por defecto es M_

```
curl -i -X GET "http://localhost:8080/app-challenge-geopagos/api/player?gender=F"
```

_**GET** Simula torneo_ 
_Parámetro gender es opcional, por defecto es M_

```
curl -i -X GET "http://localhost:8080/app-challenge-geopagos/api/championship?gender=F"
```

_**GET** Obtiene el/la ganador(a)_ 
_Parámetro gender es opcional, por defecto es M_

```
curl -i -X GET "http://localhost:8080/app-challenge-geopagos/api/championship/winner?gender=F"
```



