# PetShop

PetShop es una aplicación Android desarrollada con **Jetpack Compose** que utiliza **Retrofit** para la comunicación con APIs, **Room** para el almacenamiento local y **Hilt** para la inyección de dependencias.

## Estructura del proyecto

```text
PetShop/
├── .gradle/                    # Archivos de caché y configuración de Gradle
├── app/                        # Módulo principal de la aplicación
│   └── src/
│       └── main/
│           ├── java/com/prueba/petsop/
│           │   ├── data/       # Clases de Room (DB, DAOs)
│           │   ├── di/         # Módulos de Hilt
│           │   ├── model/      # Entidades y modelos de API
│           │   ├── network/    # Configuración de Retrofit y servicios
│           │   ├── repository/ # Repositorios (API + Room)
│           │   ├── ui/         # Pantallas y componentes Jetpack Compose
│           │   ├── viewmodel/  # ViewModels
│           │   └── PetShopApplication.kt # Clase Application
│           ├── res/            # Recursos (strings, imágenes, etc.)
│           └── AndroidManifest.xml
├── build.gradle.kts            # Configuración de Gradle a nivel proyecto
├── settings.gradle.kts         # Declaración de módulos del proyecto
└── gradle/                     # Scripts de build y configuración
```

## Tecnologías principales

| Tecnología      | Uso principal                       |
| --------------- | ----------------------------------- |
| Retrofit        | Consumo de APIs REST                |
| Room            | Almacenamiento local en dispositivo |
| Hilt            | Inyección de dependencias           |
| Jetpack Compose | UI declarativa                      |

### Retrofit

```kotlin
object RetrofitInstance {
    val api: ProductApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApiService::class.java)
    }
}
```

Los servicios de API se declaran en interfaces (`ProductApiService`) y se consumen dentro de los repositorios como `ProductRepository`.

### Room

```kotlin
@Database(
    entities = [FavoriteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}
```

Los _DAO_ (por ejemplo, `FavoriteDao`) exponen métodos para consultar e insertar datos.

### Hilt

```kotlin
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideProductApiService(retrofit: Retrofit): ProductApiService =
        retrofit.create(ProductApiService::class.java)
}
```

La clase principal está anotada con `@HiltAndroidApp`:

```kotlin
@HiltAndroidApp
class PetShopApplication : Application()
```

## Cómo ejecutar

1. Clonar repositorio.
2. Abrir proyecto en **Android Studio**.
3. Sincronizar dependencias de Gradle.
4. Ejecutar la app

## Dependencias clave

Reviar`build.gradle.kts` para la lista completa; las principales son:

- Retrofit
- Room
- Hilt
- Jetpack Compose
