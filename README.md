# EditSpinner
一款可输入文字的spinner

# 显示效果
![][1]
![][2]

# USAGE
### Gradle

``` gradle
compile 'com.wrbug:editspinner:1.1.0'
```
### Maven

``` vbscript-html
<dependency>
  <groupId>com.wrbug</groupId>
  <artifactId>editspinner</artifactId>
  <version>1.1.0</version>
  <type>pom</type>
</dependency>
```

### 更新说明
#### v1.1.0
1. 添加item监听
2. 添加编辑框最大行数
3. 修复上个版本一个bug（显示列表后点击外部隐藏，需要点击两次才能展示）

### 布局中添加

``` xml
    <com.wrbug.editspinner.EditSpinner
        android:id="@+id/editSpinner1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:Background="@drawable/bg_view_frame"
        app:hint="EditSpinner Test"
        app:rightImage="@drawable/ic_expand_more_black" />
```
### 快速使用
``` java
    spinner1 = (EditSpinner) findViewById(R.id.editSpinner1);
    spinner1.setRightImageResource(R.drawable.ic_expand_more_black);
    spinner1.setHint("EditSpinner");
    spinner2.setItemData(list);  
```
### 使用adapter

#### 实现adapter继承BaseEditSpinnerAdapter

``` java
public abstract class BaseEditSpinnerAdapter extends BaseAdapter {
    /**
     * editText输入监听
     *
     * @return
     */
    public abstract EditSpinnerFilter getEditSpinnerFilter();

    /**
     * 获取需要填入editText的字符串
     * @param position
     * @return
     */
    public abstract String getItemString(int position);

}
```

``` java
public interface EditSpinnerFilter {
    /**
     * editText输入监听
     * @param keyword
     * @return
     */
    boolean onFilter(String keyword);
}
``` 
``` java
	public class SimpleAdapter extends BaseEditSpinnerAdapter{
		...
		...
	}
``` 
#### 使用setAdapter()方法

``` java
	spinner1 = (EditSpinner) findViewById(R.id.editSpinner1);
	SimpleAdapter simpAdapter=new SimpleAdapter(this,list);
	spinner1.setAdapter(simpAdapter);
```

# 方法说明

|   方法/字段  |   参数类型  |   说明  |
| --- | --- | --- |
|  setItemData()   |  List<String>   |  备选字符串   |
|  setAdapter()   |  BaseEditSpinnerAdapter   |  /   |
|  setText()   |   String  |  设置文本   |
|  setTextColor()   |   int  |   设置文本颜色  |
| getText()    |   void  |  获取文本   |
|  setHint()   |   String  |  /   |
|  setRightImageDrawable()   |   Drawable  |  设置右边显示   |
|  setRightImageResource()   |   int  |  设置右边显示   |


# License

	Copyright 2017, Yalantis

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	   http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.


  [1]: /1.png
  [2]: /1.gif