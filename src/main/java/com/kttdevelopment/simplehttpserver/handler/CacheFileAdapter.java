package com.kttdevelopment.simplehttpserver.handler;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This class caches file bytes when adding to the {@link FileHandler}.
 *
 * @see FileHandlerAdapter
 * @see FileHandler
 * @since 4.0.0
 * @version 4.0.0
 * @author Ktt Development
 */
public class CacheFileAdapter implements FileHandlerAdapter {

    private final long cacheTimeMillis;
    private final AtomicLong closestExpiry = new AtomicLong(0);

    /**
     * Creates a CacheFileAdapter where files will expire after set milliseconds.
     *
     * @param cacheTimeMillis how long a file should exist for
     *
     * @since 4.0.0
     * @author Ktt Development
     */
    public CacheFileAdapter(final long cacheTimeMillis){
        this.cacheTimeMillis = cacheTimeMillis;
    }

    /**
     * Creates a CacheFileAdapter where files will expire after a set time.
     *
     * @param cacheTime how long a file should exist for
     * @param timeUnit the time unit
     *
     * @see TimeUnit
     * @since 4.0.0
     * @author Ktt Development
     */
    public CacheFileAdapter(final long cacheTime, final TimeUnit timeUnit){
        cacheTimeMillis = timeUnit.toMillis(cacheTime);
    }

    /**
     * Returns how long files should be cached for.
     *
     * @return file cache time
     *
     * @since 4.0.0
     * @author Ktt Development
     */
    final long getCacheTimeMillis(){
        return cacheTimeMillis;
    }

    /**
     * Returns the closest expiry.
     *
     * @return closest expiry
     *
     * @see #updateClosestExpiry(long)
     * @since 4.0.0
     * @author Ktt Development
     */
    final long getClosestExpiry(){
        return closestExpiry.get();
    }

    /**
     * Sets the closest expiry if it is less than the current expiry
     *
     * @param expiry newest expiry
     *
     * @see #getClosestExpiry()
     * @since 4.0.0
     * @author Ktt Development
     */
    final void updateClosestExpiry(final long expiry){
        final long was = closestExpiry.get();
        if(expiry < was || was < System.currentTimeMillis()) // update expiry if new is lower or if expiry has lapsed
            closestExpiry.set(expiry);
    }

    @Override
    public String toString(){
        return
            "CacheFileAdapter"  + '{' +
            "cacheTimeMillis"   + '=' + cacheTimeMillis +
            '}';
    }

}
