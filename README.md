# ButterKnife
- ButterKnife Viewbinding library for android.
- Used to avoid boilerplate issues

**Adding ButterKnife Dependency**

In your project’s go to app/build.gradle file and
add the below line

```
dependencies {
    ...
    implementation 'com.jakewharton:butterknife:8.8.1'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'
}
```

Once the dependency is added, butterknife annotations will be available to import.
- Use **@BindView** and **@OnClick** annotations for the operations.
- The **@BindView** annotation allow to inject views and performs the cast to the correct type for you.
- The **@OnClick(R.id.yourid)** annotation allows to add OnClickListener to a view. 

Butterknife also allows to unbind again, via the Unbinder object as below:

```
@Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }
  ```
