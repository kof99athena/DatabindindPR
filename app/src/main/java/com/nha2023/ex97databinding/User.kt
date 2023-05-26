package com.nha2023.ex97databinding

import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

class User {

    //값 변경이 관찰되는 멤버변수 ObservableXXX -> 프리미티브형만 되어있다. && List or Map만 되어있다.
    //참조형 레퍼런스 타입은 Field로 처리한다. <> 제네릭안에 String을 쓴다.

    var name : ObservableField<String> = ObservableField()
    var age : ObservableInt = ObservableInt(0) //이 안에 초기값을 줄수있다.
    var fav : ObservableBoolean = ObservableBoolean() //이 안에 초기값을 줄수있다.

    constructor(name : String, age : Int, fav : Boolean = true){
        //보조생성자
        this.name.set(name)
        this.age.set(age)
        this.fav.set(fav)
    }

    //change name 버튼 클릭 callback method
    //callback 메소드가 되려면 반드시 필요한 파라미터가 있어야한다.
    fun changeName(view : View){
        name.set("ROBIN") //name은 옵저버블! set으로 넣는것이다.
    }

    //age 변수값을 1 증가 시키는 기능 콜백 메소드
    fun increaseAge(view : View){ //파라미터를 써줘야한다.
        age.set(age.get()+1)
    }

    //좋아요 true / false 변경 하는 기능 메소드 : 콜백용 메소드가 아닌 그냥 일반메소드
    //이 메소드를 xml 버튼의 onclick 속성으로 지정한 익명콜백함수에서 대신 호출해줄것임.
    //파라미터가 없는데 가능?? 실제 현업이 하는 방법
    fun toggleFav(){
        fav.set(!fav.get())
    }

    //체크상태가 변경되는 것에 반응하는 콜백메소드 - 파라미터가 중요
    //이게 틀리면 함수 발동이 안된다.  파라미터가 다르면안된다.
    fun changedFav(v : CompoundButton, ischecked : Boolean){
    //이때 뷰는 화면이라는게아니라 구성요소이다
        Toast.makeText(v.context, "${ischecked}", Toast.LENGTH_SHORT).show()

        //뷰는 옵저버블을 관찰하지만
        //옵저버블은 관심받는거만 좋아할뿐..뷰를 보진않는다. 그래서!!
        //체크상태값을 관리하는 fav 변수값도 변경
        fav.set(ischecked)
    }

    //EditText의 글씨 변화 값을 가지고 있을 관찰 가능한 변수
    val message: ObservableField<String> = ObservableField("message")

    //EditText의 글씨변화 이벤트에 반응하는 콜백메소드 - 파라미터가 중요
    //파라미터 모르겠으면 object : TextWatcher를 보자
    fun onTextChange(s:CharSequence?, start:Int, end:Int, count:Int){
        message.set(s.toString())
    }

    //EditText에 글씨를 입력하고 버튼을 클릭하여 텍스트뷰에 보여주기
    private var inputValue : String = ""
    val value : ObservableField<String> = ObservableField(inputValue)

    //EditText의 글씨 변경 이벤트 콜백메소드에 의해 호출될 일반 메소드
    fun changeInputValue(s:CharSequence){
        inputValue=s.toString()
    }

    //작성 완료버튼 클릭 콜백메소드에 의해 호출될 일반 메소드
    fun clickBtn(){
        value.set(inputValue)
    }

}