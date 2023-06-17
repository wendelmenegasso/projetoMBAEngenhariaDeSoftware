package br.com.mba.engenharia.de.software.repository;

import br.com.mba.engenharia.de.software.negocio.account.Contas;
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
    public List<Contas> findAll() {
        return null;
    }

    @Override
    public List<Contas> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Contas> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Contas> findAllById(Iterable<Integer> integers) {
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
    public void delete(Contas entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Contas> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Contas> S save(S entity) {
        return entity;
    }

    @Override
    public <S extends Contas> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Contas> findById(Integer integer) {
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
    public <S extends Contas> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Contas> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Contas> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Contas getOne(Integer integer) {
        return null;
    }

    @Override
    public Contas getById(Integer integer) {
        return null;
    }

    @Override
    public Contas getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Contas> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Contas> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Contas> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Contas> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Contas> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Contas> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Contas, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
