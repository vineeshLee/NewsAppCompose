# News Application By Vineesh Lee

This is a news application built using modern Android development practices. It fetches news articles from a News API, displays them to the user, allows user to bookmark the favorite news, and implements pagination for efficient loading of a large number of articles.

## Features

*   **Browse News Articles:** View a list of the latest news articles.
*   **Pagination:** Articles are loaded in chunks as the user scrolls, improving performance and reducing data usage.
*   **Clean Architecture:** The codebase is structured following Clean Architecture principles for better separation of concerns, testability, and maintainability.
*   **MVVM (Model-View-ViewModel):** The UI layer uses the MVVM architectural pattern.
*   **Jetpack Compose:** The UI is built entirely with Jetpack Compose, Android's modern toolkit for building native UIs.

## Tech Stack & Libraries

*   **[Kotlin](https://kotlinlang.org/):** The primary programming language.
*   **[Jetpack Compose](https://developer.android.com/jetpack/compose):** Android's modern declarative UI toolkit.
*   **[Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html):** Architectural pattern for separation of concerns.
*   **[MVVM (Model-View-ViewModel)](https://developer.android.com/topic/architecture/recommendations#ui-layer):** Architectural pattern for the UI layer.
*   **[Retrofit](https://square.github.io/retrofit/):** A type-safe HTTP client for Android and Java. Used for fetching news data from the API.
*   **[Gson](https://github.com/google/gson):** A Java serialization/deserialization library to convert Java Objects into JSON and back. Used with Retrofit.
*   **[Room](https://developer.android.com/jetpack/androidx/releases/room):** A persistence library that provides an abstraction layer over SQLite to allow for more robust database access. Used for offline caching.
*   **[Coil](https://coil-kt.github.io/coil/):** An image loading library for Android backed by Kotlin Coroutines. Used for displaying article images.
*   **[Paging 3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview):** A Jetpack library that helps you load and display pages of data from a larger dataset from local storage or over network.
*   **[Hilt](https://developer.android.com/training/dependency-injection/hilt-android):** A dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
*   **[Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html):** For asynchronous programming.
*   **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel):** Stores UI-related data that isn't destroyed on UI changes.
*   **[LiveData](https://developer.android.com/topic/libraries/architecture/livedata) / [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow):** Observable data holders.
*   **[Navigation Compose](https://developer.android.com/jetpack/compose/navigation):** For navigating between screens in a Compose-based app.
*   **[DataStore Preferences](https://developer.android.com/topic/libraries/architecture/datastore):** For storing simple key-value pairs.
*   **[Splash Screen API](https://developer.android.com/develop/ui/views/launch/splash-screen):** For a smooth app launch experience.
*   **[Accompanist System UI Controller](https://google.github.io/accompanist/systemuicontroller/):** To easily control the system bar colors.

## Architecture

This application follows the principles of Clean Architecture, which promotes a separation of concerns by dividing the project into distinct layers:

*   **Domain Layer:** Contains the core business logic and use cases of the application. It is independent of any framework or platform.
*   **Data Layer:** Responsible for providing data to the domain layer. It includes implementations for repositories, data sources (network and local database), and mappers.
*   **Presentation (UI) Layer:** Displays the data to the user and handles user interactions. It consists of UI elements (Views/Composables), ViewModels, and navigation.

The MVVM pattern is used within the Presentation layer:

*   **Model:** Represents the data and business logic (primarily residing in the Domain and Data layers).
*   **View:** The UI components (Composables) that display information to the user.
*   **ViewModel:** Acts as a bridge between the View and the Model. It prepares and manages the data for the View and handles user interactions by delegating actions to the Domain layer.

## Project Structure (Conceptual)

# News Application

This is a news application built using modern Android development practices. It fetches news articles from an API, displays them to the user, allows for offline reading by caching data, and implements pagination for efficient loading of a large number of articles.

## Features

*   **Browse News Articles:** View a list of the latest news articles.
*   **Offline Caching:** News articles are stored locally, allowing users to read them even when offline.
*   **Pagination:** Articles are loaded in chunks as the user scrolls, improving performance and reducing data usage.
*   **Clean Architecture:** The codebase is structured following Clean Architecture principles for better separation of concerns, testability, and maintainability.
*   **MVVM (Model-View-ViewModel):** The UI layer uses the MVVM architectural pattern.
*   **Jetpack Compose:** The UI is built entirely with Jetpack Compose, Android's modern toolkit for building native UIs.

## Tech Stack & Libraries

*   **[Kotlin](https://kotlinlang.org/):** The primary programming language.
*   **[Jetpack Compose](https://developer.android.com/jetpack/compose):** Android's modern declarative UI toolkit.
*   **[Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html):** Architectural pattern for separation of concerns.
*   **[MVVM (Model-View-ViewModel)](https://developer.android.com/topic/architecture/recommendations#ui-layer):** Architectural pattern for the UI layer.
*   **[Retrofit](https://square.github.io/retrofit/):** A type-safe HTTP client for Android and Java. Used for fetching news data from the API.
*   **[Gson](https://github.com/google/gson):** A Java serialization/deserialization library to convert Java Objects into JSON and back. Used with Retrofit.
*   **[Room](https://developer.android.com/jetpack/androidx/releases/room):** A persistence library that provides an abstraction layer over SQLite to allow for more robust database access. Used for offline caching.
*   **[Coil](https://coil-kt.github.io/coil/):** An image loading library for Android backed by Kotlin Coroutines. Used for displaying article images.
*   **[Paging 3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview):** A Jetpack library that helps you load and display pages of data from a larger dataset from local storage or over network.
*   **[Hilt](https://developer.android.com/training/dependency-injection/hilt-android):** A dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
*   **[Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html):** For asynchronous programming.
*   **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel):** Stores UI-related data that isn't destroyed on UI changes.
*   **[LiveData](https://developer.android.com/topic/libraries/architecture/livedata) / [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow):** Observable data holders.
*   **[Navigation Compose](https://developer.android.com/jetpack/compose/navigation):** For navigating between screens in a Compose-based app.
*   **[DataStore Preferences](https://developer.android.com/topic/libraries/architecture/datastore):** For storing simple key-value pairs.
*   **[Splash Screen API](https://developer.android.com/develop/ui/views/launch/splash-screen):** For a smooth app launch experience.
*   **[Accompanist System UI Controller](https://google.github.io/accompanist/systemuicontroller/):** To easily control the system bar colors.

## Architecture

This application follows the principles of Clean Architecture, which promotes a separation of concerns by dividing the project into distinct layers:

*   **Domain Layer:** Contains the core business logic and use cases of the application. It is independent of any framework or platform.
*   **Data Layer:** Responsible for providing data to the domain layer. It includes implementations for repositories, data sources (network and local database), and mappers.
*   **Presentation (UI) Layer:** Displays the data to the user and handles user interactions. It consists of UI elements (Views/Composables), ViewModels, and navigation.

The MVVM pattern is used within the Presentation layer:

*   **Model:** Represents the data and business logic (primarily residing in the Domain and Data layers).
*   **View:** The UI components (Composables) that display information to the user.
*   **ViewModel:** Acts as a bridge between the View and the Model. It prepares and manages the data for the View and handles user interactions by delegating actions to the Domain layer.


