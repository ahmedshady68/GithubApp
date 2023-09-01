# GithubApp
a simple single screen app which shows the current trending Github repositories fetched from a public API.

Android Kottlin Application that build in clean archticture and best practisies

## summary
 In this Application we have 1 screen

Github trending list screen : that have a trending Github repositories list.

## Archticture
 We follow the [onion architicture](https://medium.com/android-dev-hacks/detailed-guide-on-android-clean-architecture-9eab262a9011)
 
 So we have 3 layers:
 
●	Domain layer: Would execute business logic which is independent of any layer and is just a pure kotlin package with no android specific dependency.

●	Data layer: Would dispense the required data for the application to the domain layer by implementing interface exposed by the domain

●	App layer:
Would include both domain and data layer and is android specific which executes the UI logic.

<img src="https://user-images.githubusercontent.com/8076006/232272370-c7f80389-d612-4bbb-a077-5cc2550e962e.jpg" width= "900">


## Dependency Injection

We use Dagger Hilt to apply dependency injection


## API 

●	 [API url](https://api.github.com/search/repositories?q=language=+sort:stars)




