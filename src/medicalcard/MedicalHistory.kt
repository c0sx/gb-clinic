package medicalcard

class MedicalHistory(records: List<MedicalRecord>) {
    private val _records = records.toMutableList()

    public fun add(record: MedicalRecord) {
        _records.add(record)
    }

    public fun size(): Int {
        return _records.size
    }
}