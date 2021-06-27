package reception.exception

import reception.ReceptionException

class PatientIsBusyException: ReceptionException("Запланирован другой приём на данное время")