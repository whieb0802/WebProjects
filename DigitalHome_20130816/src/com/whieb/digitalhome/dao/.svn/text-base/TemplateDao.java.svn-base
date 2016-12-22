package com.whieb.digitalhome.dao;

import java.util.List;

import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.Template;

public interface TemplateDao {
  public List<Template> findTemplate();
  public void save(Template t);
  public List<Template> findSequence();
  public List<Template> findNextTemplate(String type);
  public List<Item> getNextData(long id, String type,int topN);
}
