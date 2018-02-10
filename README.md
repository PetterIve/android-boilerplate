# android-boilerplate

## Todo
- [ ] Unit tests
- [ ] RxViews
- [ ] RxSharedPreferences

### Configuring RX for tests not running on Android
```kotlin
companion object {
    @BeforeClass
    @JvmStatic
    fun setupClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { _ -> Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { _ -> Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { _ -> Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { _ -> Schedulers.trampoline() }
    }
    @AfterClass
    @JvmStatic fun teardown() {
        RxAndroidPlugins.reset()
    }
}
```