# Visiting Morocco Guide

An offline Android travel guide to eight of Morocco's most visited cities. Pick a city, read a short introduction, then dive into its landmarks, markets, food and activities — each with its own illustrated page.

## Cities covered

| City | What the guide covers |
|---|---|
| **Marrakech** | Traditional markets, riads, food, landmarks |
| **Tangier** | The Kasbah, the Caves of Hercules, markets, Cape Spartel beach |
| **Casablanca** | Hassan II Mosque, Morocco Mall, Ain Diab Corniche beach |
| **Chefchaouen** | The blue medina, the Kasbah, artisanal crafts, its streets |
| **Dakhla** | The lagoon, White Dune, Dragon Island, food, kitesurfing and other activities |
| **Agadir** | The Kasbah, the beach, activities |
| **Rabat** | Kasbah of the Udayas, Hassan Tower, Archaeological Museum, food |
| **Fez** | The Medina of Fez, Al-Qarawiyyin Mosque and University, food, traditional art |

8 cities and 30 detail pages in total, all content bundled in the app — no internet needed to read the guide.

## How it's built

- **Language:** Java
- **Platform:** Android, min SDK 24 (Android 7.0), target/compile SDK 33
- **UI:** XML layouts with AppCompat, Material Components and ConstraintLayout
- **Monetization:** Google Mobile Ads (AdMob) interstitial ads, shown when opening a city or topic page
- **Build:** Gradle 7.5 (wrapper included) with Android Gradle Plugin 7.4.2

Navigation is a simple three-level tree of activities:

```
MainActivity                 → city list (8 buttons)
 └─ Data_<city>              → city intro + topic buttons
     └─ Data_<city>_<topic>  → topic page (text + images)
```

Cities are numbered `one`…`nine` (Marrakech = `one`, Tangier = `two`, Casablanca = `three`, Chefchaouen = `four`, Dakhla = `five`, Agadir = `six`, Rabat = `eight`, Fez = `nine`), so `Data_five_two` is the second topic page for Dakhla.

## Project structure

```
app/src/main/
├── java/com/Visiting_Morocco/Guide/   # MainActivity + one activity per city and per topic
├── res/layout/                        # activity_main.xml and activity_data_*.xml screens
├── res/drawable*/                     # city and attraction photos (~160 images)
└── AndroidManifest.xml
```

## Getting started

1. Install [Android Studio](https://developer.android.com/studio) (JDK 11 or newer is required by AGP 7.4).
2. Clone the repo:
   ```bash
   git clone https://github.com/omar-abidi-dev/morocco-travels.git
   ```
3. Open the folder in Android Studio and let Gradle sync.
4. Run the `app` configuration on an emulator or a device running Android 7.0+.

### Ads during development

The project contains real AdMob app and ad unit IDs. When running debug builds, swap them for [Google's test ad IDs](https://developers.google.com/admob/android/test-ads) (or register your device as a test device) so you don't generate invalid traffic on the live account.

### Release builds

Signing keystores are intentionally **not** in this repository. To build a signed release, create your own keystore in Android Studio (*Build → Generate Signed Bundle / APK*).

## Ideas for improvement

- Move city text into `strings.xml` for translations (Arabic, French, Spanish)
- Replace the per-page activities with one data-driven screen (e.g. a `RecyclerView` fed by JSON)
- Add maps and directions for each attraction
- Migrate to Kotlin and the newer Android Gradle Plugin

## Author

**Omar Abidi** — [@omar-abidi-dev](https://github.com/omar-abidi-dev)
