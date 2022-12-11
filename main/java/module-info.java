module com.example.demo {
	
	//imports com
    requires transitive javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;

    opens com.example.demo to javafx.fxml;
    
    exports com.example.demo;
}