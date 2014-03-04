package br.cin.ufpe.nesc2cpn.repository;

import java.util.List;

/**
 *
 * @author avld
 */
public interface Repository {
    public void add(Line line) throws Exception;
    public void update(Line line) throws Exception;
    public Line get(String moName, String itName, String meName) throws Exception;
    public void delete(Line line) throws Exception;
    public List<Line> list() throws Exception;
    public List<Line> list(String moName, String itName, String meName) throws Exception;
}