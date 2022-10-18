package tads.eaj.ufrn.detonaseries.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Serie (
    var titulo:String,
    var sinopse:String,
    var lancamento:Int,
    var classificacao:Float
){
    @PrimaryKey (autoGenerate = true)
    var id:Long = 0
}