package com.app.container;
import com.app.storage.IBag;

/**
 * Common interface for any container builder
 */
public interface IBagFactory {
    // Create a new container, according to the specified type
    IBag makeBag(String type);
}
