package com.nha2023.ex97databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nha2023.ex97databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       //1. 이러면 안된다!!!!!!!  setContentView(R.layout.activity_main) 액티비티가 스스로 레이아웃을 잡고있다. 안된다.

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
       //2. 데이터 바인딩에서는 뷰 바인딩과 다르게 layout.xml의 root요소가 <layout>이여만 바인딩 클래스가 만들어짐.

        //layout.xml에서 <data>요소 안에 있는 <variable>의 타입으로 지정한 User클래스를 객체로 생성하여 값을 지정
        //어디다 연결해야한다고? layout영역을 전체 붙잡고있는게 binding이다. (데이터도 같이 갖고있다.)
        binding.user = User("sam",20)
    }
}