# SECOND HAND · (JavaFX)

> Simulación de una tienda de ropa de segunda mano desarrollada en **Java (proyecto JavaFX / NetBeans)**. Incluye un menú de consola para gestionar artículos, usuarios, búsquedas y pedidos.

![Pantalla](tiendaRopa.png)

---

## ✨ Funcionalidades

- **Gestión de artículos**: alta, baja, modificación y listado.  
- **Gestión de usuarios**: alta, baja, modificación y listado.  
- **Búsquedas** de artículos y de usuarios.  
- **Realizar pedidos** desde el propio menú.  

---

## 📁 Estructura del proyecto

TiendaRopa/
├─ src/ # Código fuente Java
├─ nbproject/ # Metadatos de NetBeans
├─ build.xml # Script de compilación Ant
├─ manifest.mf # Manifest del jar
├─ tiendaRopa.png # Captura de pantalla
└─ README.md

## 🧰 Requisitos

- **JDK 11+** (recomendado JDK 17).  
- **Apache Ant** (si compilas por terminal) *o* **NetBeans** (si abres el proyecto directamente).  
- Sistema operativo: Windows, macOS o Linux.

---

## 🚀 Puesta en marcha

### Opción A) NetBeans (más sencillo)
1. Abre NetBeans → **File > Open Project...**  
2. Selecciona la carpeta `TiendaRopa/`.  
3. Haz clic en **Run** para compilar y ejecutar.

### Opción B) Terminal con Ant
1. Instala Ant y asegúrate de tener `JAVA_HOME` configurado.  
2. En la raíz del repo:

```bash
# Compilar
ant clean compile

# Empaquetar JAR
ant jar

# Ejecutar (ajusta la ruta si tu Ant genera en otra carpeta)
java -jar dist/TiendaRopa.jar
