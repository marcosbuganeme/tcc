package br.com.cvagal.utilitarios;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/**
 * <p>
 * <b>Título:</b> Transacao.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Anotação responsável por interceptar e realizar a validação da transação. Se certo, ela retorna com o commit, caso contrário, rollback.
 * </p>
 *
 * Data de criação: 16/11/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface Transacao {

}
