# RSHK jsifenlib

`rshk-jsifenlib` es una librería de código abierto, sin dependencias externas, para interactuar con SIFEN (Sistema
Integrado de Factura Electrónica Nacional) a través de un SDK para el lenguaje Java versión 8.

## Instalación

### Maven

```xml
<dependencies>
    <dependency>
        <groupId>com.roshka.sifen</groupId>
        <artifactId>rshk-jsifenlib</artifactId>
        <version>0.2.2</version>
    </dependency>
</dependencies>
```

### Gradle

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'com.roshka.sifen:rshk-jsifenlib:0.2.2'
}
```

## Servicios Web de SIFEN

- Consulta de RUC
- Recepción de Documento Electrónico - Síncrono
- Consulta de Documentos Electrónicos
- Recepción de Lote de Documentos Electrónicos - Asíncrono
- Consulta de Estado de Documentos Electrónicos (Lote)
- Recepción de Eventos

## Uso

***Importante: Leer
el [Manual Técnico de Sifen](https://ekuatia.set.gov.py/rest/contents/download/collaboration/sites/ekuatia/documents/documentacion/documentacion-tecnica/Manual+T%C3%A9cnico+Versi%C3%B3n+150.pdf)
y entender el funcionamiento básico antes de continuar con la guía de uso de esta librería.***

### Configuración

Para utilizar las funciones ofrecidas por `RSHK jsifenlib` es necesario configurar los siguientes ítems:

- Tipo de Ambiente (Desarrollo o Producción)
- Certificado y Tipo de Certificado (Solo PFX está soportado actualmente)
- Código de Seguridad (CSC)

Para esto, crear una nueva instancia de la clase `SifenConfig` utilizando alguno de los constructores:

```java
// Constructor vacío. Los valores se deben agregar por medio de los *setters* de la clase.
SifenConfig config = new SifenConfig();

// Constructor con el tipo de ambiente, tipo de certificado, la ruta del certificado y la contraseña.
SifenConfig config = new SifenConfig(
    SifenConfig.TipoAmbiente.PROD,
    SifenConfig.TipoCertificadoCliente.PFX,
    "C:\\Users\\Roshka\\Documents\\certificado.pfx",
    "password"
);

// Constructor igual al anterior, con el CSC y su ID.
SifenConfig config = new SifenConfig(
    SifenConfig.TipoAmbiente.PROD,
    "0002", // ID CSC
    "EFGH0000000000000000000000000000", // CSC
    SifenConfig.TipoCertificadoCliente.PFX,
    "C:\\Users\\Roshka\\Documents\\certificado.pfx",
    "password"
);
```

La clase `SifenConfig` también se puede crear a partir de un método de construcción que toma los datos de un
archivo de propiedades de la siguiente manera:

```java
SifenConfig sifenConfig = SifenConfig.loadFromFileName("conf/sifen.properties");
```

Este archivo debe tener el siguiente formato, dependiendo de las necesidades:

```properties
# Esto puede ser:
# DEV (apunta al ambiente de desarrollo/test de SIFEN)
# PROD (apunta al ambiente de producción de SIFEN)
sifen.ambiente=DEV

# NO modificar a menos que uno sepa bien lo que está haciendo
# sifen.url_base=

# Si se va a usar el certificado cliente.
# Este valor en el 99.99% de las veces va a ser true
# a menos que uno sepa bien lo que está haciendo
sifen.certificado_cliente.usar=true
# Por ahora, el único valor aceptado es PFX
sifen.certificado_cliente.tipo=PFX

## RUTA APUNTANDO AL ARCHIVO PFX
sifen.certificado_cliente.archivo=/home/charly/garcia.pfx

## PASSWORD del ARCHIVO PFX
sifen.certificado_cliente.contrasena=my_password

## CSC
sifen.csc=ABCD0000000000000000000000000000
sifen.csc.id=0001
```
Luego de preparar la configuración, establecer la misma para usarla con las diferentes consultas.

```java
Sifen.setSifenConfig(config);
```

Esto solo debe realizarse una vez al principio, antes de ejecutar alguna acción. Si la configuración necesita ser
actualizada, simplemente invocar de vuelta.

### Consulta de RUC

El uso del servicio web de Consulta de RUC se puede realizar de la siguiente forma:

```java
RespuestaConsultaRUC respuesta = Sifen.consultaRUC("80089752");
```

El parámetro es el RUC del contribuyente a consultar, sin el DV (Dígito Verificador).

Para ver la estructura de la respuesta a esta consulta, revisar el Manual Técnico de Sifen, cuyo enlace se encuentra al
principio de esta sección.

## Sugerencias

Si tenés alguna duda o consulta, o encontraste un comportamiento incorrecto dentro de la librería, no dudes en crear
un *issue*.

## Contribución

Cualquier contribución es siempre bienvenida. Por favor, crear primero un *issue* para discutir los cambios a ser
realizados.

## Licencia

`RSHK jsifenlib` está licenciada bajo el MIT License. Ver el archivo [LICENCIA.md](LICENCIA.md) para más detalles.

Para parsear objetos JSON, se utilizó la librería [minimal-json](https://github.com/ralfstx/minimal-json) que 
también está liberado bajo la reglamentación de la [licencia de MIT](http://opensource.org/licenses/MIT). Para 
simplicidad de los despliegues, se metió la librería dentro del propio proyecto de JSIFEN-LIB.

## Empresas usuarias de jsifenlib

Algunas empresas que utilizan esta librería en producción para sus implementaciones de SIFEN (*) son:

1. [Taxare S.A.](https://www.taxit.com.py) para su producto TAXit! (2021-05)
2. [NEXO S.A.E.C.A](http://www.nexo.com.py) (2022-03)
3. [Roshka S.A.](https://www.roshka.com) (2022-04)
4. [SIFAMERICA S.A.](https://www.sif.com.py) (2022-11)
5. [Despachos Aduaneros Cacavelos](http://www.despachoscacavelos.com.py/) (2022-11)
6. [Biggie S.A.](https://www.biggie.com.py/) (2023-01)
7. [Banco de la Nación Argentina](https://www.bna.com.py/) (2023-01)
8. [VIDRIO LUZ SRL](http://www.vidrioluz.com.py/web/) (2023-01)
9. [UNION SRL](http://www.unionsrl.com.py) (2023-04)

(*) ¿Querés agregar la tuya? Envianos un [email](mailto:pablo@roshka.com.py) para incluirla. 

## Autores y Responsables

- Pablo Santa Cruz ([github/pablo](https://github.com/pablo))
- Martin Zarza ([github/martinzarza](https://github.com/martinzarza))
- David Ayala ([github/david-ayala](https://github.com/david-ayala))
