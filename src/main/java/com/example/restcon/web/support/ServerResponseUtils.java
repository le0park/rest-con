/*
 * @(#)ServerResponseUtils.java 2022. 03. 19
 */

package com.example.restcon.web.support;

import org.reactivestreams.Publisher;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

/**
 * @author le0park
 */
public class ServerResponseUtils {
	/**
	 * ok with application/json
	 * @param publisher
	 * @param elementClass
	 * @param <T>
	 * @param <P>
	 * @return
	 */
	public static <T, P extends Publisher<T>> Mono<ServerResponse> okJson(
		P publisher,
		Class<T> elementClass
	) {
		return ok(publisher, elementClass, MediaType.APPLICATION_JSON);
	}

	/**
	 * ok with application/json
	 * @param publisher
	 * @param elementTypeRef
	 * @param <T>
	 * @param <P>
	 * @return
	 */
	public static <T, P extends Publisher<T>> Mono<ServerResponse> okJson(
		P publisher,
		ParameterizedTypeReference<T> elementTypeRef
	) {
		return ok(publisher, elementTypeRef, MediaType.APPLICATION_JSON);
	}

	/**
	 * ok
	 * @param publisher
	 * @param elementClass
	 * @param mediaType
	 * @param <T>
	 * @param <P>
	 * @return
	 */
	public static <T, P extends Publisher<T>> Mono<ServerResponse> ok(
		P publisher,
		Class<T> elementClass,
		MediaType mediaType
	) {
		return ServerResponse.ok().contentType(mediaType).body(publisher, elementClass);
	}

	/**
	 * ok
	 * @param publisher
	 * @param elementTypeRef
	 * @param mediaType
	 * @param <T>
	 * @param <P>
	 * @return
	 */
	public static <T, P extends Publisher<T>> Mono<ServerResponse> ok(
		P publisher,
		ParameterizedTypeReference<T> elementTypeRef,
		MediaType mediaType
	) {
		return ServerResponse.ok().contentType(mediaType).body(publisher, elementTypeRef);
	}

	/**
	 * ok with application/json
	 * @param inserter
	 * @return
	 */
	public static Mono<ServerResponse> okJson(BodyInserter<?, ? super ServerHttpResponse> inserter) {
		return ok(inserter, MediaType.APPLICATION_JSON);
	}

	/**
	 * ok
	 * @param inserter
	 * @param mediaType
	 * @return
	 */
	public static Mono<ServerResponse> ok(
		BodyInserter<?, ? super ServerHttpResponse> inserter,
		MediaType mediaType
	) {
		return ServerResponse.ok().contentType(mediaType).body(inserter);
	}

	/**
	 * status with application/json
	 * @param status
	 * @param publisher
	 * @param elementClass
	 * @param <T>
	 * @param <P>
	 * @return
	 */
	public static <T, P extends Publisher<T>> Mono<ServerResponse> statusJson(
		HttpStatus status,
		P publisher,
		Class<T> elementClass
	) {
		return status(status.value(), publisher, elementClass, MediaType.APPLICATION_JSON);
	}

	/**
	 * status with application/json
	 * @param status
	 * @param publisher
	 * @param elementClass
	 * @param <T>
	 * @param <P>
	 * @return
	 */
	public static <T, P extends Publisher<T>> Mono<ServerResponse> statusJson(
		int status,
		P publisher,
		Class<T> elementClass
	) {
		return status(status, publisher, elementClass, MediaType.APPLICATION_JSON);
	}

	/**
	 * status
	 * @param status
	 * @param publisher
	 * @param elementClass
	 * @param mediaType
	 * @param <T>
	 * @param <P>
	 * @return
	 */
	public static <T, P extends Publisher<T>> Mono<ServerResponse> status(
		int status,
		P publisher,
		Class<T> elementClass,
		MediaType mediaType
	) {
		return ServerResponse.status(status).contentType(mediaType).body(publisher, elementClass);
	}

	/**
	 * status with application/json
	 * @param status
	 * @param publisher
	 * @param elementTypeRef
	 * @param <T>
	 * @param <P>
	 * @return
	 */
	public static <T, P extends Publisher<T>> Mono<ServerResponse> statusJson(
		HttpStatus status,
		P publisher,
		ParameterizedTypeReference<T> elementTypeRef
	) {
		return status(status.value(), publisher, elementTypeRef, MediaType.APPLICATION_JSON);
	}

	/**
	 * status with application/json
	 * @param status
	 * @param publisher
	 * @param elementTypeRef
	 * @param <T>
	 * @param <P>
	 * @return
	 */
	public static <T, P extends Publisher<T>> Mono<ServerResponse> statusJson(
		int status,
		P publisher,
		ParameterizedTypeReference<T> elementTypeRef
	) {
		return status(status, publisher, elementTypeRef, MediaType.APPLICATION_JSON);
	}

	/**
	 * status
	 * @param status
	 * @param publisher
	 * @param elementTypeRef
	 * @param mediaType
	 * @param <T>
	 * @param <P>
	 * @return
	 */
	public static <T, P extends Publisher<T>> Mono<ServerResponse> status(
		int status,
		P publisher,
		ParameterizedTypeReference<T> elementTypeRef,
		MediaType mediaType
	) {
		return ServerResponse.status(status).contentType(mediaType).body(publisher, elementTypeRef);
	}

	/**
	 * status with application/json
	 * @param status
	 * @param inserter
	 * @return
	 */
	public static Mono<ServerResponse> statusJson(
		HttpStatus status,
		BodyInserter<?, ? super ServerHttpResponse> inserter
	) {
		return status(status.value(), inserter, MediaType.APPLICATION_JSON);
	}

	/**
	 * status with application/json
	 * @param status
	 * @param inserter
	 * @return
	 */
	public static Mono<ServerResponse> statusJson(
		int status,
		BodyInserter<?, ? super ServerHttpResponse> inserter
	) {
		return status(status, inserter, MediaType.APPLICATION_JSON);
	}

	/**
	 * status
	 * @param status
	 * @param inserter
	 * @param mediaType
	 * @return
	 */
	public static Mono<ServerResponse> status(
		int status,
		BodyInserter<?, ? super ServerHttpResponse> inserter,
		MediaType mediaType
	) {
		return ServerResponse.status(status).contentType(mediaType).body(inserter);
	}
}
