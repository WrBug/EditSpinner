# EditSpinner
![](https://github.com/wangtao2132/EditSpinner/blob/master/1.gif)

# Usage
### Step 1
##### 
    <cn.mandroid.widget.editspinner.EditSpinner
        android:id="@+id/editSpinner1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:Background="@drawable/bg_view_frame"
        app:hint="EditSpinner Test"
        app:rightImage="@drawable/ic_expand_more_black" />
### Step 2
    spinner1 = (EditSpinner) findViewById(R.id.editSpinner1);
    spinner1.setRightImageResource(R.drawable.ic_expand_more_black);
    spinner1.setHint("EditSpinner");
    spinner2.setItemData(list);   
