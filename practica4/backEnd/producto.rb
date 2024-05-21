class Producto < ApplicationRecord
  enum categoria:{
    cosmeticos:'cosmeticos',
    alimentacion:'alimentacion',
    ropa:'ropa',
    ninguna:'ninguna'
  }
end
