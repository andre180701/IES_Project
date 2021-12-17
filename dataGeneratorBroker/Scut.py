import itertools
from datetime import date

class Scut:
    newid = itertools.count()
    def __init__(self, latitude, longitude, priceClass1, priceClass2, priceClass3, priceClass4, priceClass5 ) -> None:
        self._id = next(Scut.newid)
        self._latitude = latitude
        self._longitude = longitude
        self._instalationDate = date.today()
        self._priceClass1 = priceClass1
        self._priceClass2 = priceClass2
        self._priceClass3 = priceClass3
        self._priceClass4 = priceClass4
        self._priceClass5 = priceClass5

    def get_id(self):
        return self._id

    def get_latitude(self):
        return self._latitude

    def get_longitude(self):
        return self._longitude

    def get_instalationDate(self):
        return self._instalationDate

    def get_priceClass1(self):
        return self._priceClass1

    def get_priceClass2(self):
        return self._priceClass2

    def get_priceClass3(self):
        return self._priceClass3

    def get_priceClass4(self):
        return self._priceClass4

    def get_priceClass5(self):
        return self._priceClass5

    def set_priceClass1(self, priceClass1):
        self._priceClass1 = priceClass1

    def set_priceClass2(self, priceClass2):
        self._priceClass2 = priceClass2

    def set_priceClass3(self, priceClass3):
        self._priceClass3 = priceClass3

    def set_priceClass4(self, priceClass4):
        self._priceClass4 = priceClass4

    def set_priceClass5(self, priceClass5):
        self._priceClass5 = priceClass5

    '''
    def __str__(self) -> str:
        return 

    def __repr__(self) -> str:
        return self.__str__()
    '''
