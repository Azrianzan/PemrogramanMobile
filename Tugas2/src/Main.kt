data class Sepatu(
    var id: Int,
    var merk: String,
    var warna: String,
    var ukuran: Int,
    var harga: Double
)

fun main() {
    val sepatuList: MutableList<Sepatu> = mutableListOf()
    var nextId = 1

    while (true) {
        println("\n=== Menu ===")
        println("1. Tunjukkan Data Sepatu")
        println("2. Tambahkan Data Sepatu")
        println("3. Edit Detail Sepatu")
        println("4. Hapus Data Sepatu")
        println("5. Lihat Detail Sepatu")
        println("6. Keluar")
        print("Pilih menu: ")

        when (readLine()?.toIntOrNull()) {
            1 -> showData(sepatuList)
            2 -> addData(sepatuList, nextId).also { nextId++ }
            3 -> editData(sepatuList)
            4 -> deleteData(sepatuList)
            5 -> viewDetail(sepatuList)
            6 -> break
            else -> println("Menu tidak valid. Silakan coba lagi.")
        }
    }
}

fun showData(sepatuList: List<Sepatu>) {
    if (sepatuList.isEmpty()) {
        println("Tidak ada data sepatu.")
    } else {
        println("\n=== Data Sepatu ===")
        sepatuList.forEach { sepatu ->
            println("ID: ${sepatu.id}, Merk: ${sepatu.merk}")
        }
    }
}

fun addData(sepatuList: MutableList<Sepatu>, id: Int) {
    print("Masukkan merk sepatu: ")
    val merk = readLine()?.takeIf { it.isNotEmpty() } ?: run {
        println("Merk tidak boleh kosong.")
        return
    }

    print("Masukkan warna sepatu: ")
    val warna = readLine()?.takeIf { it.isNotEmpty() } ?: run {
        println("Warna tidak boleh kosong.")
        return
    }

    print("Masukkan ukuran sepatu: ")
    val ukuran = readLine()?.toIntOrNull() ?: run {
        println("Ukuran tidak valid.")
        return
    }

    print("Masukkan harga sepatu: ")
    val harga = readLine()?.toDoubleOrNull() ?: run {
        println("Harga tidak valid.")
        return
    }

    sepatuList.add(Sepatu(id, merk, warna, ukuran, harga))
    println("Data sepatu berhasil ditambahkan.")
}

fun editData(sepatuList: MutableList<Sepatu>) {
    print("Masukkan ID sepatu yang ingin diedit: ")
    val id = readLine()?.toIntOrNull() ?: run {
        println("ID tidak valid.")
        return
    }

    val sepatu = sepatuList.find { it.id == id }
    sepatu?.let {
        print("Masukkan merk baru (${it.merk}): ")
        val newMerk = readLine()?.takeIf { it.isNotEmpty() } ?: it.merk

        print("Masukkan warna baru (${it.warna}): ")
        val newWarna = readLine()?.takeIf { it.isNotEmpty() } ?: it.warna

        print("Masukkan ukuran baru (${it.ukuran}): ")
        val newUkuran = readLine()?.toIntOrNull() ?: it.ukuran

        print("Masukkan harga baru (${it.harga}): ")
        val newHarga = readLine()?.toDoubleOrNull() ?: it.harga

        it.merk = newMerk
        it.warna = newWarna
        it.ukuran = newUkuran
        it.harga = newHarga
        println("Data sepatu berhasil diupdate.")
    } ?: println("Sepatu dengan ID $id tidak ditemukan.")
}

fun deleteData(sepatuList: MutableList<Sepatu>) {
    print("Masukkan ID sepatu yang ingin dihapus: ")
    val id = readLine()?.toIntOrNull() ?: run {
        println("ID tidak valid.")
        return
    }

    val sepatu = sepatuList.find { it.id == id }
    sepatu?.let {
        sepatuList.remove(it)
        println("Data sepatu berhasil dihapus.")
    } ?: println("Sepatu dengan ID $id tidak ditemukan.")
}

fun viewDetail(sepatuList: List<Sepatu>) {
    print("Masukkan ID sepatu yang ingin dilihat: ")
    val id = readLine()?.toIntOrNull() ?: run {
        println("ID tidak valid.")
        return
    }

    val sepatu = sepatuList.find { it.id == id }
    sepatu?.let {
        println("\n=== Detail Sepatu ===")
        println("ID: ${it.id}")
        println("Merk: ${it.merk}")
        println("Warna: ${it.warna}")
        println("Ukuran: ${it.ukuran}")
        println("Harga: $${it.harga}")
    } ?: println("Sepatu dengan ID $id tidak ditemukan.")
}