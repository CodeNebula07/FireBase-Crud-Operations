package com.FireBaseCrudOperations.Config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FireBaseConfig {

    // This method is called after the bean initialization and is used to initialize Firestore.
    @PostConstruct
    private void initFireStore() throws IOException {
        // Load the service account private key JSON file.
        InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("private-key-firestore.json");

        // Build FirebaseOptions with the loaded credentials and the database URL.
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://post-management-53713.firebaseio.com/")
                .build();

        // Check if a FirebaseApp instance already exists. If not, initialize FirebaseApp with the given options.
        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }
    }

    // Retrieve the Firestore instance, which is used for performing CRUD operations.
    public Firestore getFirestore() {
        return FirestoreClient.getFirestore();
    }
}
