# StateButtonView

## Customizable attributes

|        Attribute       |      default value     |
|------------------------|------------------------|
|`use_gradient`            |`false`                   |
|`angle`                   |`90`                      |
|`normal_start_color`      |`COLOR_DEFAULT`           |
|`normal_end_color`        |`COLOR_DEFAULT_DARK`      |
|`pressed_start_color`     |`COLOR_PRESSED`           |
|`pressed_end_color`       |`COLOR_PRESSED_DARK`      |
|`selected_start_color`    |`COLOR_PRESSED`           |
|`selected_end_color`      |`COLOR_PRESSED_DARK`      |
|`disabled_start_color`    |`COLOR_DISABLED`          |
|`disabled_end_color`      |`COLOR_DISABLED_DARK`     |
|`ripple`                  |`false`                   |
|`ripple_color`            |`COLOR_DEFAULT`           |
|`rounded`                 |`false`                   |
|`corner_radius`           |`0`                       |
|`top_left_radius`         |`0`                       |
|`top_right_radius`        |`0`                       |
|`bottom_right_radius`     |`0`                       |
|`bottom_left_radius`      |`0`                       |
|`solid_color`             |`COLOR_DEFAULT`           |
|`solid_color_pressed`     |`COLOR_PRESSED`           |
|`solid_color_selected`    |`COLOR_PRESSED`           |
|`solid_color_disabled`    |`COLOR_DISABLED`          |
|`stroke_width`            |`0`                       |
|`stroke_color`            |`0`                       |
|`stroke_color_pressed`    |`0`                       |
|`stroke_color_selected`   |`0`                       |
|`stroke_color_disabled`   |`0`                       |

## User in xml
```
...
xmlns:app="http://schemas.android.com/apk/res-auto"
...

<jo.dis.button.StateButtonView
    android:id="@+id/test_btn"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    android:enabled="true"
    android:padding="10dp"
    android:text="Hello World!"
    app:corner_radius="5dp"
    app:ripple="false"
    app:rounded="false"
    app:solid_color="@color/purple_200"
    app:stroke_color="@color/teal_200"
    app:stroke_color_pressed="@color/teal_700"
    app:stroke_width="2dp"
    app:use_gradient="false" />

```

