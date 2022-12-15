module com.example.demo {
	
	
    requires transitive javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;

    opens com.example.demo.controller to javafx.fxml;
   
    exports com.example.demo;
    exports com.example.demo.controller;
    exports com.example.demo.model;
    exports com.example.demo.pages;
    exports util;
}

