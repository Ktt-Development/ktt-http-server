package com.kttdevelopment.simplehttpserver.handler;

import com.sun.net.httpserver.HttpHandler;
import com.kttdevelopment.simplehttpserver.SimpleHttpHandler;

/**
 * By default the {@link com.sun.net.httpserver.HttpServer} will use the most specific context for requests; this however causes the context <code>/</code> to catch all contexts without an associated handler, instead of sending a 404 or no response. This workaround will process requests at <code>/</code> only and send all other requests to a different handler (typically a 404 page will be set here).
 *
 * @see SimpleHttpHandler
 * @see HttpHandler
 * @since 01.00.00
 * @version 4.4.0
 * @author Ktt Development
 */
public class RootHandler extends PredicateHandler {

    /**
     * Creates a root handler.
     *
     * @param rootHandler handler for the context <code>/</code>
     * @param elseHandler handler for all other contexts (typically a 404 page)
     *
     * @see SimpleHttpHandler
     * @see HttpHandler
     * @since 01.00.00
     * @author Ktt Development
     */
    public RootHandler(final HttpHandler rootHandler, final HttpHandler elseHandler){
        super(
            httpExchange -> httpExchange.getRequestURI().getPath().equals("/"),
            rootHandler,
            elseHandler
        );
    }

}
