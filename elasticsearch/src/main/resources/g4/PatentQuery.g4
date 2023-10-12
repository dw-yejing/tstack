grammar PatentQuery;

parseQuery returns [QueryBuilder queryBuilder]
    : expression EOF {$queryBuilder = $expression.queryBuilder;}
    ;

expression returns [QueryBuilder queryBuilder]
    : atom                     {$queryBuilder = $atom.queryBuilder;}
      ( 'and' atom            {$queryBuilder = QueryBuilders.boolQuery().must($queryBuilder).must($atom.queryBuilder);}
      | 'or'  atom            {$queryBuilder = QueryBuilders.boolQuery().should($queryBuilder).should($atom.queryBuilder);}
      )*
    ;

atom returns [QueryBuilder queryBuilder]
    : 'Ti' '='? text=STRING   {$queryBuilder = QueryBuilders.matchQuery("title", $text.getText());}
    | 'ad' '='? year=INT     {$queryBuilder = QueryBuilders.termQuery("year", $year.getText());}
    ;
