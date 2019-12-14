package ktt.lib.httpserver.http;

/**
 * A list of expected HTTP method requests.
 * See <a href="https://tools.ietf.org/html/rfc7231#section-4.3" target="_blank">IANA RFC7324 Section 4.3</a>
 * @since 01.00.00
 * @version 01.00.00
 * @author Ktt Development
 */
public enum RequestMethod {
    GET,
    HEAD,
    POST,
    PUT,
    DELETE,
    CONNECT,
    OPTIONS,
    TRACE,
    PATCH,
    UNSUPPORTED
}