# Prácticas de Diseño de Software (DS)

Este repositorio contiene las prácticas desarrolladas para la asignatura de **Diseño de Software** de la Universidad de Granada. El objetivo ha sido aplicar patrones de diseño y principios de arquitectura de software para construir sistemas robustos, mantenibles y escalables.

## 📁 Contenido del Repositorio

El repositorio está organizado en carpetas, cada una correspondiente a una entrega. Las prácticas muestran una progresión desde la implementación de patrones de diseño básicos hasta la creación de una aplicación cliente-servidor completa.

### Práctica 1: Patrones Creacionales
Enfoque en la creación de objetos de manera flexible.
* **Ejercicio 1 (Java):** Implementación del patrón **Abstract Factory** para crear familias de objetos relacionados (bicicletas y carreras de montaña/carretera). Se utiliza concurrencia (`Threads`) para simular las carreras.
* **Ejercicio 2 (Python):** Adaptación del ejercicio anterior utilizando el patrón **Prototype** para clonar objetos (bicicletas) a partir de una instancia original.

### Práctica 2: Patrones Estructurales y de Comportamiento
Aplicación de patrones para organizar clases y definir la comunicación entre objetos.
* **Ejercicio 3 (Java):** Uso del patrón **Composite** para crear una estructura jerárquica de elementos web (Páginas, Contenido, Textos, Imágenes).
* **Ejercicio 4 (Java):** Implementación del patrón **Intercepting Filter** para simular el salpicadero de un coche, con una interfaz gráfica en `JFrame`.
* **Ejercicio 5 (Python):** Aplicación del patrón **Strategy** para desarrollar un sistema de *web scraping* que extrae datos de Yahoo Finance usando dos estrategias intercambiables: **BeautifulSoup** y **Selenium**.

### Práctica 3: Interfaz de Tienda con Filtros
Desarrollo de una aplicación de escritorio centrada en la interacción y el filtrado de datos.
* **Simulación de Tienda (Dart):** Creación de una interfaz gráfica para una tienda online donde se pueden visualizar productos, añadirlos a una cesta y filtrarlos.
* **Patrón Intercepting Filter:** Se reutiliza este patrón para aplicar secuencialmente filtros a la lista de productos por categoría, precio mínimo/máximo o si están en oferta.

### Práctica 4: Aplicación Cliente-Servidor
Evolución de la práctica anterior hacia una arquitectura full-stack.
* **Frontend (Dart):** La aplicación de la tienda actúa como cliente, realizando peticiones HTTP a un servidor para gestionar los datos de forma persistente.
* **Backend (Ruby on Rails):** Creación de una API RESTful para gestionar los productos. El servidor se encarga de las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) contra una base de datos.

## 🛠️ Tecnologías Utilizadas

* **Lenguajes:** Java, Python, Dart, Ruby.
* **Frameworks y Librerías:**
    * **Java:** Swing (para `JFrame`).
    * **Python:** BeautifulSoup, Selenium.
    * **Dart:** Flutter (para la UI).
    * **Ruby:** Ruby on Rails (para la API).
* **Modelado:** UML.
* **Bases de Datos:** SQL (a través de Active Record en Rails).
* **Protocolos:** HTTP (para la comunicación cliente-servidor).
