package br.com.mba.engenharia.de.software.repository;

import br.com.mba.engenharia.de.software.negocio.account.Conta;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ContasRepositoyImpl implements ContasRepository{

    @Override
    public List<Conta> findAll() {
        return null;
    }

    @Override
    public List<Conta> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Conta> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Conta> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Conta entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Conta> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Conta> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Conta> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Conta> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Conta> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Conta> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Conta> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Conta getOne(Integer integer) {
        return null;
    }

    @Override
    public Conta getById(Integer integer) {
        return null;
    }

    @Override
    public Conta getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Conta> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Conta> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Conta> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Conta> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Conta> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Conta> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Conta, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
